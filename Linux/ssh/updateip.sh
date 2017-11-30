#!/bin/bash
echo "Running..."
ip=`wget -qO- http://ipecho.net/plain`
name=`hostname`
name=${name,,}
date=`date`
prog=$name.connect.sh
echo "#!/bin/bash" > $prog
echo "ssh -XC rflec028@$ip" >> $prog
echo "#RCF - Last updated $date" >> $prog
chmod +x $prog
