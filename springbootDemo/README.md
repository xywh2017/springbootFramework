PostGres configuration
=====================================
1.error:
FATAL: password authentication failed for user "postgres"

resolve it as bellow:
goto C:\Program Files\PostgreSQL\9.5\data
change md5 to trust, save file.
restart postgres service.
