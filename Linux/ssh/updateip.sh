#!/bin/bash
#RCF 2017

#GATHER INFORMATION
ip=`wget -qO- http://ipecho.net/plain`
name=`hostname`
name=${name,,}
date=`date`
prog=$name.connect.sh
data=ip.$name
lastip=`cat $data`

#WRITE FILES
echo "$ip" > $data
echo "#!/bin/bash" > $prog
echo "ssh -XC rflec028@$ip" >> $prog
echo "#RCF - Last updated $date" >> $prog
chmod +x $prog
mkdir -p ~/Remote
for x in *.connect.sh; do
  \cp $x ~/Remote/$x
done

#UPLOAD CHANGES
if [ $lastip != $ip ]; then
  echo "IP Changed from $lastip to $ip! Pushing changes."
  git add $prog
  git commit -m "RCF-AUTO: Updated IP for $name."
  git push
fi


