$ cat pull-all.sh
srcdir=$(pwd)

for dir in */; do
    echo "Git pull $srcdir$dir"
    cd $srcdir/$dir
    git pull
done
