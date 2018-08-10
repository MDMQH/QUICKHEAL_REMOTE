@setlocal enableextensions
set datestamp=%date:~-4,4%%date:~-10,2%%date:~7,2%
set testsuite=MDM_Sanity_Test_Report
set dir_dest=E:\Repository\mdm\Omkar\Reports\

mkdir %dir_dest%%testsuite%_%datestamp%

echo directory %dir_dest%%testsuite%_%datestamp% created successfully.

set src_ss=E:\Repository\mdm\Omkar\Reports\Failed Case Screenshot\*
set surefire_report=E:\Repository\mdm\Omkar\target\site\*

set dest_report=E:\Repository\mdm\Omkar\Reports\%testsuite%_%datestamp%\

move "%src_ss% " "%dest_report%"
move "%surefire_report% " "%dest_report%"