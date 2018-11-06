set PATH=D:\MyDevelop\jdk8\bin;%PATH%
set PATH=set PATH=D:\MyDevelop\gradle-4.10.2\bin;%PATH%
set JAVA_HOME=D:\MyDevelop\jdk8
set GRADLE_HOME=D:\MyDevelop\gradle-4.10.2
set GRADLE_USER_HOME=D:\MyDevelop\gradle-user-home
D:
cd D:D:\MyDevelop\workspaces\base\PringbootStut
call gradle clean
call gradle build
cd build\libs
java -jar PringbootStut-1.0.0.0.jar
pause