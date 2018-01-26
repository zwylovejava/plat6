package net.northking.cloudplatform.utils;

/**
 * 用于解析思维导图节点
 * Created by xiusong.xie on 2017/11/14.
 */
public class TestPointTextGener
{
  private static final String REGEX = "->";
  private String fullName;
  private String[] pointTexts;

  public TestPointTextGener(String fullName)
  {
    this.fullName = fullName;
    this.pointTexts = fullName.split(REGEX);
  }

  public String getModuleText()
  {
    return this.pointTexts[0];
  }

  public String getFuncText()
  {
    if (pointTexts.length > 1)
    {
      return this.pointTexts[1];
    } else
    {
      return this.getModuleText();
    }
  }

  public String getSubFuncText()
  {
    if (pointTexts.length > 2)
    {
      return this.pointTexts[2];
    } else
    {
      return this.getFuncText();
    }
  }

  public String getItemText()
  {
    if (pointTexts.length > 3)
    {
      return this.pointTexts[3];
    } else
    {
      return this.getSubFuncText();
    }
  }

  public String getPointTexts()
  {
    if (pointTexts.length > 4)
    {
      StringBuffer text = new StringBuffer("");
      for (int i = 4; i < pointTexts.length; i++)
      {
        text.append("->");
        text.append(pointTexts[i]);
      }
      return text.toString().substring(2);
    } else
    {
      return this.getItemText();
    }
  }
}
