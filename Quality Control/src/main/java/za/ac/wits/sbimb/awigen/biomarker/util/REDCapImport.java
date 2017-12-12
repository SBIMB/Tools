/**
 * 
 */
package za.ac.wits.sbimb.awigen.biomarker.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
/**
 * @author Freedom Mukomana
 *
 */
public class REDCapImport{
  private final List<NameValuePair> params;
  private final HttpPost post;
  private HttpResponse resp;
  private final HttpClient client;
  private int respCode;
  private BufferedReader reader;
  private final StringBuffer result;
  private String line;

  public REDCapImport(){
    params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("token", "08CAB966E585F1A4CE6A5CC32F409942"));
    params.add(new BasicNameValuePair("content", "report"));
    params.add(new BasicNameValuePair("format", "csv"));
    params.add(new BasicNameValuePair("report_id", "3725"));
    params.add(new BasicNameValuePair("rawOrLabel", "raw"));
    params.add(new BasicNameValuePair("rawOrLabelHeaders", "raw"));
    params.add(new BasicNameValuePair("exportCheckboxLabel", "true"));
    params.add(new BasicNameValuePair("returnFormat", "xml"));

    post = new HttpPost("https://redcap.core.wits.ac.za/redcap/api/");
    post.setHeader("Content-Type", "application/x-www-form-urlencoded");

    try
    {
      post.setEntity(new UrlEncodedFormEntity(params));
    }
    catch (final Exception e)
    {
      e.printStackTrace();
    }

    result = new StringBuffer();
    client = HttpClientBuilder.create().build();
    respCode = -1;
    reader = null;
    line = null;
  }

  public String doPost()
  {
    resp = null;

    try
    {
      resp = client.execute(post);
    }
    catch (final Exception e)
    {
      e.printStackTrace();
    }

    if(resp != null)
    {
      respCode = resp.getStatusLine().getStatusCode();

      try
      {
        reader = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
      }
      catch (final Exception e)
      {
        e.printStackTrace();
      }
    }

    if(reader != null)
    {
      try
      {
        while ((line = reader.readLine()) != null)
        {
          result.append(line);
          result.append(";");
        }
      }
      catch (final Exception e)
      {
        e.printStackTrace();
      }
    }
   
    System.out.println("respCode: " + respCode);
    System.out.println("result: " + result.toString());
    return result.toString();
  }
}