Copyright: 
https://github.com/jenkinsci/chucknorris-plugin/
(was taken as example)

Tutorials:

https://blog.codecentric.de/en/2013/02/tutorial-jenkins-plugin-development/

https://jenkinsapi.readthedocs.org/

https://cleantestcode.wordpress.com/2013/11/03/how-to-write-a-jenkins-plugin-introduction/
https://cleantestcode.wordpress.com/2013/11/03/how-to-write-a-jenkins-plugin-part-1/
https://cleantestcode.wordpress.com/2013/11/28/how-to-write-a-jenkins-plugin-part-2/
https://cleantestcode.wordpress.com/2013/11/28/how-to-write-a-jenkins-plugin-part-3/
https://cleantestcode.wordpress.com/2013/11/29/how-to-write-a-jenkins-plugin-part-4/

http://blog.sacaluta.com/2009/04/hudson-plugin-2-adding-post-build.html

http://javaadventure.blogspot.com/2008/01/writing-hudson-plug-in-part-1.html



Get Started:

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

http://localhost:8090/


//Temp;
build.@result = hudson.model.Result.FAILURE;