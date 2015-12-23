#!/bin/bash



if [ $# -eq 0 ]; then
	echo "Action argument not found."
	echo "Possible arguments: start/stop/status"
else
	ACTION=$1
fi


function run {

	nohup java -jar /servers/opencv/projectopencv/target/projectopencv-0.0.1.jar > /servers/opencv/projectopencv/logs.txt &
	echo $! > /servers/opencv/projectopencv/pid.dat
	echo "Opencv Server started succesfully..."
}


if [[ $ACTION == 'start' ]]; then
	
	if [ ! -s /servers/opencv/projectopencv/pid.dat ]; then

		if [ -s /servers/opencv/projectopencv/pid.dat ]; then
			
			PID=`cat /servers/opencv/projectopencv/pid.dat`
			if ! ps -p $PID > null ; then
				run
			fi

		else
			run
		fi
	else
		PID=`cat /servers/opencv/projectopencv/pid.dat`
		echo "opencv Service already running under PID $PID"
	fi

elif [[ $ACTION == 'stop' ]]; then

		PID=`cat /servers/opencv/projectopencv/pid.dat`
		
		if [ ! -z "$PID" ]; then

			kill -9 $PID
			> /servers/opencv/projectopencv/pid.dat
			echo "opencv Service stoped successfully."

		else 

			echo "No Server Running..."
		fi

elif [[ $ACTION == 'status' ]]; then

			if [ -s /servers/opencv/projectopencv/pid.dat ]; then

				PID=`cat /servers/opencv/projectopencv/pid.dat`

				if ps -p $PID > null ;then
					echo "opencv Service running under PID $PID"
				else

					> /servers/opencv/projectopencv/pid.dat
					echo "No Service Running."
				fi
			else
				echo "No Service Running."
			fi
else
	echo "Unknown arguments' $*"
fi