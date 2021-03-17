# HARDENING UBUNTU 18.04

## DESHABILITAR SISTEMAS DE ARCHIVOS NO UTILIZADOS
**Los Siguientes comandos se deben ejecutar en la terminal y no deben arrojar ningun proceso**
1. lsmod | grep cramfs
2. lsmod | grep freevxfs
3. lsmod | grep jffs2
4. lsmod | grep hfsplus
5. lsmod | grep udf

# El sistema de archivos temporales no estan habilitados
1. mount | grep /tmp

# Talk
**El software de conversación permite a los usuarios enviar y recibir mensajes a través de los sistemas a través de una sesión de terminal.**
1. grep -R "^talk" /etc/inetd.*
2. grep -R "^ntalk" /etc/inetd.*
3. dpkg -s talk
**Nota: no se encuentra instalado el directorio ya que el paquete no se encuentra instalado**

# telnet
**El paquete telnet-server contiene el demonio telnet, que acepta conexiones de usuarios de otros sistemas a través del protocolo telnet.**
1. grep -R "^telnet" /etc/inetd.*

**Nota: no se encuentra instalado el directorio**

# tftp
**El protocolo trivial de transferencia de archivos (TFTP) es un protocolo simple de transferencia de archivos, que generalmente se usa para transferir automáticamente configuraciones o máquinas de arranque desde un servidor de arranque. Los paquetes tftpd y atftp se usan para definir y admitir un servidor TFTP.**
1. grep -R "^tftp" /etc/inetd.*

**Nota: no se encuentra instalado el directorio**


# Avahi

**es una implementación gratuita de zeroconf, que incluye un sistema para el descubrimiento de servicios de multidifusión DNS / DNS-SD. Avahi permite que los programas publiquen y descubran servicios y hosts que se ejecutan en una red local sin una configuración específica. Por ejemplo, un usuario puede conectar una computadora en una red y Avahi encuentra automáticamente impresoras para imprimir, archivos para mirar y personas con quienes hablar, así como servicios de red que se ejecutan en la máquina.**
1. systemctl is-enabled avahi-daemon

**Nota: no se encuentra habilitado el servicio**

# CUPS
**El sistema de impresión Common Unix (CUPS) proporciona la capacidad de imprimir en impresoras locales y de red. Un sistema que ejecuta CUPS también puede aceptar trabajos de impresión desde sistemas remotos e imprimirlos en impresoras locales. También proporciona una capacidad de administración remota basada en web.**
1. systemctl is-enabled cups

**Nota: no se encuentra habilitado el servicio**

# SNMP
**El servidor del Protocolo simple de administración de redes (SNMP) se utiliza para escuchar los comandos SNMP de un sistema de administración SNMP, ejecutar los comandos o recopilar la información y luego enviar los resultados al sistema solicitante.**
1. systemctl is-enabled snmpd

**Nota: no se encuentra habilitado el servicio**

# NIS
**El Servicio de información de red (NIS), anteriormente conocido como Páginas amarillas, es un protocolo de servicio de directorio cliente-servidor que se utiliza para distribuir archivos de configuración del sistema. El cliente NIS (ypbind) se usó para vincular una máquina a un servidor NIS y recibir los archivos de configuración distribuidos.**
1. dpkg -s nis

**Nota: el paquete no se encuentra instalado**

# TCP SYN Cookies
**Cuando se establece tcp_syncookies, el kernel manejará los paquetes TCP SYN normalmente hasta que la cola de conexión semiabierta esté llena, momento en el que se activará la funcionalidad de la cookie SYN. ​​Las cookies SYN funcionan al no utilizar la cola SYN. En cambio, el núcleo simplemente responde al SYN con un SYN | ACK, pero incluirá un número de secuencia TCP especialmente diseñado que codifica la dirección IP de origen y destino y el número de puerto y la hora en que se envió el paquete. Una conexión legítima enviaría el paquete ACK del protocolo de enlace de tres vías con el número de secuencia especialmente diseñado. Esto permite que el sistema verifique que recibió una respuesta válida a una cookie SYN y permite la conexión, aunque no haya SYN correspondiente en la cola.**

1. sysctl net.ipv4.tcp_syncookies

**Nota: OK**

# Audit
**Instalación**
1. sudo apt-get install auditd
2. service auditd start
3. systemctl is-enabled auditd

**Nota: direccion de la configuración del audit => sudo nano /etc/audit/auditd.conf y la ruta donde almacena el log => /var/log/audit/audit.log, Para generar el reporte del día de hoy se realiza por medio del siguiente comando ausearch --start today**

## AUDIT TUTORIAL

1. sudo auditctl -l => verifica las reglas implementadas

**Pagina de Reglas => https://sio2sio2.github.io/doc-linux/04.servidor/08.monitorizacion/02.audit/index.html**


# CRON
**El demonio cron se usa para ejecutar trabajos por lotes en el sistema. Si bien puede que no haya trabajos de usuario que deban ejecutarse en el sistema,El sistema tiene trabajos de mantenimiento que pueden incluir monitoreo de seguridad que deben ejecutarse, y cron se usa para ejecutarlos.**

1. systemctl is-enabled cron