import jenkins.model.Jenkins
import com.hsbc.jenkins.workflow.log.Logger

@groovy.transform.Field Logger logger

def call () {
    this.logger = new Logger()
    this.logger.trace("vars/Utilities.groovy called.")
    return this
}

public Boolean jobExists(String jobName){
    this.logger.trace("vars/Utilities.groovy::jobExists start.")
    Boolean jobExists = false

    Jenkins.instance.getAllItems(hudson.model.Job).find{ it ->
            it.name.equals(jobName)
    }.each{job ->
        jobExists = true
    }

    this.logger.info("Job ${jobName} exists? ${jobExists}")

    this.logger.trace("vars/Utilities.groovy::jobExists end.")
    return jobExists
}