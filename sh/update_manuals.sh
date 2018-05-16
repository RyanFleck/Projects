#!/bin/bash
#RCF 2018

echo "Updating manuals in projects repo."

# Move to projects and pull files.
cd //home/user/projects
echo "Pull new project files."
git pull

#Move to website and pull files
cd //home/user/website
echo "Pull new website files."
git pull

cd //home/user/website/_manuals
echo "Manuals available:"
ls

for man in *.markdown; do
  title=`grep "title: " $man`
  title="${title##title: }"
  echo "Copying $man, the $title doc to ${man%.markdown} projects repo."
  rm //home/user/projects/${man%.markdown}/README.md
  echo "# Ryan's $title Manual" > //home/user/projects/${man%.markdown}/README.md
  #cp $man //home/user/projects/${man%.markdown}/README.md
  sed '1 { /^---/ { :a N; /\n---/! ba; d} }' $man >> //home/user/projects/${man%.markdown}/README.md
  sed -i '/Table of Contents/d' //home/user/projects/${man%.markdown}/README.md
  sed -i '/1. Seed list entry./d' //home/user/projects/${man%.markdown}/README.md
  sed -i '/{:toc}/d' //home/user/projects/${man%.markdown}/README.md
done

echo "Push to repos."
cd //home/user/projects
git add .
git commit -a -m "Updated manuals!"
git push
