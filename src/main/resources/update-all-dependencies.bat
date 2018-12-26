echo Updating dependencies in package.json
cd C:\Users\olzi\workspace\qa\frontend
echo npm i -g npm-check-updates
rem call npm i -g npm-check-updates
echo ncu -ua (gets all the new dependencies and puts it into package.json)
rem call ncu -ua
echo npm install
call npm install
echo done updating dependencies in package.json
