
<cluster-user>k4YM6rob</cluster-user>

      <cluster-password>x5AZ35Yk</cluster-password>
      
 <acceptor name="amqp">tcp://ex-aao-ss-0.ex-aao-hdls-svc.new-message-project.svc.cluster.local:5672?protocols=AMQP;sslEnabled=true;keyStorePath=/etc/amq7brokersecret-volume/broker.ks;keyStorePassword=artemis7;trustStorePath=/etc/amq7brokersecret-volume/client.ts;trustStorePassword=artemis7;connectionsAllowed=25;tcpSendBufferSize=1048576;tcpReceiveBufferSize=1048576;useEpoll=true;amqpCredits=1000;amqpMinCredits=300</acceptor><acceptor name="scaleDown">tcp://ex-aao-ss-0.ex-aao-hdls-svc.new-message-project.sv
c.cluster.local:61616?protocols=CORE;tcpSendBufferSize=1048576;tcpReceiveBufferSize=1048576;useEpoll=true;amqpCredits=1000;amqpMinCredits=300</acceptor>
      </acceptors>
      
           

= Spring-Boot Camel XML QuickStart

This example demonstrates how to configure Camel routes in Spring Boot via
a Spring XML configuration file.

The application utilizes the Spring http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ImportResource.html[`@ImportResource`] annotation to load a Camel Context definition via a _src/main/resources/spring/camel-context.xml_ file on the classpath.

IMPORTANT: This quickstart can run in 2 modes: standalone on your machine and on Kubernetes / OpenShift Cluster

== Deployment options

You can run this quickstart in the following modes:

* Kubernetese / Single-node OpenShift cluster
* Standalone on your machine

The most effective way to run this quickstart is to deploy and run the project on OpenShift.

For more details about running this quickstart on a single-node OpenShift cluster, CI/CD deployments, as well as the rest of the runtime, see the link:http://appdev.openshift.io/docs/spring-boot-runtime.html[Spring Boot Runtime Guide].

== Running the Quickstart on a single-node Kubernetes/OpenShift cluster

IMPORTANT: You need to run this example on Container Development Kit 3.3 or OpenShift 3.7.
Both of these products have suitable Fuse images pre-installed.
If you run it in an environment where those images are not preinstalled follow the steps described in <<single-node-without-preinstalled-images>>.

A single-node Kubernetes/OpenShift cluster provides you with access to a cloud environment that is similar to a production environment.

If you have a single-node Kubernetes/OpenShift cluster, such as Minishift or the Red Hat Container Development Kit, link:http://appdev.openshift.io/docs/minishift-installation.html[installed and running], you can deploy your quickstart there.


. Log in to your OpenShift cluster:
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ oc login -u developer -p developer
----

. Create a new OpenShift project for the quickstart:
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ oc new-project MY_PROJECT_NAME
----

. Change the directory to the folder that contains the extracted quickstart application (for example, `my_openshift/spring-boot-camel-xml`) :
+
or
+ 
[source,bash,options="nowrap",subs="attributes+"]
----
$ cd my_openshift/spring-boot-camel-xml
----

. Build and deploy the project to the OpenShift cluster:
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ mvn clean -DskipTests fabric8:deploy -Popenshift
----

. In your browser, navigate to the `MY_PROJECT_NAME` project in the OpenShift console.
Wait until you can see that the pod for the `spring-boot-camel-xml` has started up.

. On the project's `Overview` page, navigate to the details page deployment of the `spring-boot-camel-xml` application: `https://OPENSHIFT_IP_ADDR:8443/console/project/MY_PROJECT_NAME/browse/rcs/spring-boot-camel-xml-NUMBER_OF_DEPLOYMENT?tab=details`.

. Switch to tab `Logs` and then see the messages sent by Camel.

[#single-node-without-preinstalled-images]
=== Running the Quickstart on a single-node Kubernetes/OpenShift cluster without preinstalled images

A single-node Kubernetes/OpenShift cluster provides you with access to a cloud environment that is similar to a production environment.

If you have a single-node Kubernetes/OpenShift cluster, such as Minishift or the Red Hat Container Development Kit, link:http://appdev.openshift.io/docs/minishift-installation.html[installed and running], you can deploy your quickstart there.


. Log in to your OpenShift cluster:
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ oc login -u developer -p developer
----

. Create a new OpenShift project for the quickstart:
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ oc new-project MY_PROJECT_NAME
----

. Import base images in your newly created project (MY_PROJECT_NAME):
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ oc import-image fuse-java-openshift:2.0 --from=registry.access.redhat.com/jboss-fuse-7/fuse-java-openshift:2.0 --confirm
----

. Change the directory to the folder that contains the extracted quickstart application (for example, `my_openshift/spring-boot-camel-xml`) :
+
or
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ cd my_openshift/spring-boot-camel-xml
----

. Build and deploy the project to the OpenShift cluster:
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ mvn clean -DskipTests fabric8:deploy -Popenshift -Dfabric8.generator.fromMode=istag -Dfabric8.generator.from=MY_PROJECT_NAME/fuse-java-openshift:2.0
----

. In your browser, navigate to the `MY_PROJECT_NAME` project in the OpenShift console.
Wait until you can see that the pod for the `spring-boot-camel-xml` has started up.

. On the project's `Overview` page, navigate to the details page deployment of the `spring-boot-camel-xml` application: `https://OPENSHIFT_IP_ADDR:8443/console/project/MY_PROJECT_NAME/browse/pods/spring-boot-camel-xml-NUMBER_OF_DEPLOYMENT?tab=details`.

. Switch to tab `Logs` and then see the messages sent by Camel.

== Running the quickstart standalone on your machine
To run this quickstart as a standalone project on your local machine:

. Download the project and extract the archive on your local filesystem.
. Build the project:
+
[source,bash,options="nowrap",subs="attributes+"]
----
$ cd PROJECT_DIR
$ mvn clean package
----
. Run the service:

+
[source,bash,options="nowrap",subs="attributes+"]
----
$ mvn spring-boot:run
----
. See the messages sent by Camel.
