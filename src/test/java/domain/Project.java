package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
  private Integer id;
  private String name;
  private String description;
  private String type;
  private String status;
  private String color;
  @JsonProperty(value = "is_trial")
  private Boolean isTrial;
  @JsonProperty(value = "is_seen")
  private Boolean isSeen;
  private String file;
  @JsonProperty(value = "testrail_file")
  private String testrailFile;
  private String url;
  @JsonProperty(value = "project_devices")
  private List<ProjectDevice> projectDevices;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<ProjectDevice> getProjectDevices() {
    return projectDevices;
  }

  public void setProjectDevices(List<ProjectDevice> projectDevices) {
    this.projectDevices = projectDevices;
  }

  public Project() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Boolean getTrial() {
    return isTrial;
  }

  public void setTrial(Boolean trial) {
    isTrial = trial;
  }

  public Boolean getSeen() {
    return isSeen;
  }

  public void setSeen(Boolean seen) {
    isSeen = seen;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getTestrailFile() {
    return testrailFile;
  }

  public void setTestrailFile(String testrailFile) {
    this.testrailFile = testrailFile;
  }
}
