package com.siteco;

import java.io.*;
import java.util.Properties;

public class Config  implements Serializable
{
    private final String DEFAULT_CONFIG_FILE_NAME = "config.properties";
    private Properties m_oProp=null;
    private int m_iResult;
    
    public Config()
    {
        m_oProp = new Properties();
        Read("");
    }

    public Config(String sConfigFileName)
    {
        m_oProp = new Properties();
        Read(sConfigFileName);
    }

    private long Read(String sConfigFileName)
    {
        m_iResult =-1;
        
        if(null!=m_oProp)
        {
            if(sConfigFileName.equals(""))
			{
                sConfigFileName=DEFAULT_CONFIG_FILE_NAME;
			}
            
            ClassLoader oLoader = getClass().getClassLoader();
            java.net.URL url = oLoader.getResource(sConfigFileName);
            //java.net.URL url = getClass().getResource(sConfigFileName);
            if (url!=null)
            {
                try
                {
                    sConfigFileName = java.net.URLDecoder.decode(url.getFile(), "UTF-8");
                }
                catch (UnsupportedEncodingException e)
                {                 
                }
            }
            File oConfigFile = new File(sConfigFileName);
            if(null!=oConfigFile)
            {
                if(oConfigFile.exists())
                {
                    try
                    {
                        m_oProp.load(new FileInputStream(oConfigFile));
                        m_iResult=0;
                    }
                    catch(FileNotFoundException exc)
                    {
                    }
                    catch(IOException exc)
                    {
                    }                
                }
                else
                {
                    try
                    {
                        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(DEFAULT_CONFIG_FILE_NAME);
                        m_oProp.load(inputStream);
                        m_iResult=0;
                    }
                    catch(Exception exc)
                    {
                    }
                }
                /*}
                else
                {
                    try
                    {
                        m_oTracer.traceError(this, "Read() - File not found: Path["+oConfigFile.getPath()+"] AbsolutePath["+oConfigFile.getAbsolutePath()+"] CanonicalPath["+oConfigFile.getCanonicalPath()+"]");
                    }
                    catch(IOException exc)
                    {
                        m_oTracer.traceException(this,"Read() - IO Exception while tracing an error on file: " + oConfigFile.getPath(), exc);
                    }                
                }*/
            }
            else
            {
            }
        }
        return m_iResult;
    }

    public String getData( String sKey )
    {
        String sData="";
        
        try
        {
            sData = m_oProp.getProperty(sKey);
        }
        catch(Exception exc)
        {
        }                
        return sData;    
    }

    public boolean isLoaded()
    {
        return m_iResult==0;
    }
}