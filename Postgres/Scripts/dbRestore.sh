sudo service postgresql restart
sudo -su postgres psql -c "drop database zf_bogota"
sudo -su postgres psql -c "create database zf_bogota"
sudo -u postgres psql zf_bogota < /home/superaccess/Database/authorization.backup