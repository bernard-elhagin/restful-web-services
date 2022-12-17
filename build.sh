# Build the jar without running tests
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk

mvn clean install -DskipTests
