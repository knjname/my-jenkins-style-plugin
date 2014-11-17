package name.knj.myjenkins;

import hudson.Extension;
import hudson.model.PageDecorator;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

@Extension
public class MyJenkinsPageDecorator extends PageDecorator {

	private boolean customizeAppearance;
	private boolean customizeHeader;
	private boolean customizeFooter;

	public MyJenkinsPageDecorator() {
		super(MyJenkinsPageDecorator.class);
		load();
	}

	@Override
	public boolean configure(StaplerRequest req, JSONObject formData)
			throws FormException {
		if(this.customizeAppearance = formData.containsKey("customizeAppearance")){
			JSONObject customizeAppearance = formData.getJSONObject("customizeAppearance");
			this.customizeHeader = customizeAppearance.getBoolean("customizeHeader");
			this.customizeFooter = customizeAppearance.getBoolean("customizeFooter");
		}
		
		save();
		
		return super.configure(req, formData);
	}

	public boolean getCustomizeAppearance() {
		return customizeAppearance;
	}

	public boolean getCustomizeHeader() {
		return customizeHeader;
	}

	public boolean getCustomizeFooter() {
		return customizeFooter;
	}

}
