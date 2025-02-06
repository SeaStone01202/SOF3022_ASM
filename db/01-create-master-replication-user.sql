CREATE USER 'giang_repl'@'%' IDENTIFIED BY 'giang';
GRANT REPLICATION SLAVE ON *.* TO 'giang_repl'@'%';
FLUSH PRIVILEGES;
ALTER USER 'giang_repl'@'%' IDENTIFIED WITH mysql_native_password BY 'giang';
FLUSH PRIVILEGES;
STOP group_replication;
SET GLOBAL group_replication_bootstrap_group=1;
START GROUP_REPLICATION;
SET GLOBAL group_replication_bootstrap_group=0;
show master status;/* Ghi lại thông tin từ file và position để chỉnh sửa bên 02

