**How to use Maven deploy plugin to deploy a new snapshot to Nexus:**
* Make sure you have ~/.m2/settings.xml placed
* Add server config: 
    `<server><id>nexus-snapshots</id><username></username><password></password></server>`
* Set correct project version (i.e. x.y-SNAPSHOT) and run "mvn clean deploy"


