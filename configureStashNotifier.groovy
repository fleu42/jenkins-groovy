#!groovy
import jenkins.model.*;
import org.jenkinsci.plugins.*;
import net.sf.json.JSONObject;

String url = 'https://stashblablablabla';
String credentials = '01111111-e222-3333-eeff-4f4444e44bc4';

def j = Jenkins.getInstance();

def stash = j.getExtensionList(
  stashNotifier.StashNotifier.DescriptorImpl.class)[0];

def formData = [
  stashRootUrl: url,
  credentialsId: credentials,
  ignoreUnverifiedSsl: false,
  includeBuildNumberInKey: false,
  prependParentProjectKey: false,
  disableInprogressNotification: false,
  considerUnstableAsSuccess: false
] as JSONObject;

stash.configure(null, formData);
j.save();
