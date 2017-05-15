#!/bin/bash
#make sure to cache your password!
echo "Ryan's git update script."
echo "Adding..."
git add *
echo "Commit changes..."
git commit -m "Updated files."
echo "Push to master..."
git push origin master
echo " "
echo "Finished."
echo " "
