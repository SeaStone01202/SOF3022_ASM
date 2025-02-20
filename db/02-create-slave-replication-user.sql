CREATE USER 'giang_repl'@'%' IDENTIFIED BY 'giang'; /*giữ nguyên giống với user replication của host node1*/
GRANT REPLICATION SLAVE ON *.* TO 'giang_repl'@'%'; /*giữ nguyên giống với user replication của host node1*/
FLUSH PRIVILEGES; /*giữ nguyên giống với user replication của host node1*/
STOP SLAVE;
CHANGE REPLICATION SOURCE TO
    SOURCE_HOST='node1', 
    SOURCE_USER='giang_repl', /*giữ nguyên giống với user replication của host node1*/
    SOURCE_PASSWORD='giang', /*giữ nguyên giống với user replication của host node1*/
    SOURCE_LOG_FILE='mysql-bin-1.000020', /*thông tin của file*/
    SOURCE_LOG_POS=233;/* thông tin của position*/
START SLAVE;
SHOW SLAVE STATUS; /*Xem thông tin đã được kết nối chưa, nếu thấy đang chờ 'Waiting for source to send event' thì đã đúng*/
SELECT user, host FROM mysql.user;/*Sau khi đã oke thì phải restart lại docker container*/