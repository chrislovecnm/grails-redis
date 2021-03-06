grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        //mavenRepo "http://m2repo.spockframework.org/snapshots"
        mavenRepo "http://m2repo.spockframework.org/snapshots"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
    }
    plugins {
        runtime ":build-test-data:1.1.1"
        test ":spock:0.6-SNAPSHOT"
        test ":code-coverage:1.2.5"
        test ":codenarc:0.16.1"
    }
}

grails.plugin.location.redis = "../../.."

codenarc {
    processTestUnit = false
    processTestIntegration = false
    propertiesFile = 'codenarc.properties'
    ruleSetFiles = "file:grails-app/conf/redis-codenarc.groovy"
    reports = {
        RedisDefaultProjectReport('xml') {                    // The report name "MyXmlReport" is user-defined; Report type is 'xml'
            outputFile = 'target/codenarc.xml'  // Set the 'outputFile' property of the (XML) Report
            title = 'Grails Redis Default Project'             // Set the 'title' property of the (XML) Report
        }
    }
}
