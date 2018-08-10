@SET mdm_workspace=E:\workspace\MDM
@SET workspace_drive=e:

@ECHO ***********************************************
@ECHO   MDM Sanity Suite
@ECHO ***********************************************
@ECHO ***********************************************
@ECHO  Cleaning Project - mvn clean
@ECHO ***********************************************
@cd /d E:\Repository\mdm\Omkar
@CALL mvn clean
@ECHO ***********************************************
@ECHO  Executing Test - mvn test
@ECHO ***********************************************
@CALL mvn site