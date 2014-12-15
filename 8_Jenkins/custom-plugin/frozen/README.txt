https://cleantestcode.wordpress.com/2013/11/03/how-to-write-a-jenkins-plugin-introduction/
https://cleantestcode.wordpress.com/2013/11/03/how-to-write-a-jenkins-plugin-part-1/
https://cleantestcode.wordpress.com/2013/11/28/how-to-write-a-jenkins-plugin-part-2/
https://cleantestcode.wordpress.com/2013/11/28/how-to-write-a-jenkins-plugin-part-3/
https://cleantestcode.wordpress.com/2013/11/29/how-to-write-a-jenkins-plugin-part-4/

http://blog.sacaluta.com/2009/04/hudson-plugin-2-adding-post-build.html

build.@result = hudson.model.Result.FAILURE;




settings.xml:

<pluginGroup>org.jenkins-ci.tools</pluginGroup>


<profile>
<id>jenkins</id>
<activation>
<activeByDefault>false</activeByDefault>
</activation>
<repositories>
<repository>
<id>repo.jenkins-ci.org</id>
<url>http://repo.jenkins-ci.org/public/</url>
</repository>
</repositories>
<pluginRepositories>
<pluginRepository>
<id>repo.jenkins-ci.org</id>
<url>http://repo.jenkins-ci.org/public/</url>
</pluginRepository>
</pluginRepositories>
</profile>





mvn hpi:create -Pjenkins

mvn clean install -Pjenkins

mvn hpi:run -Djetty.port=8090 -Pjenkins

http://localhost:8090/jenkins/

