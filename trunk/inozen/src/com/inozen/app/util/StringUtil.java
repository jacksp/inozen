package com.inozen.app.util;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * String���� ��ƿ����.
 * @version 1.0
 */
public class StringUtil {
	
	/**
	* @param tobetested �˻��� ���ڿ�
	*/
	public final static boolean isEmpty ( final String tobetested )	{
		if ( ( tobetested != null )	&& ( !tobetested.trim().equals("") ) ) {
			return false;
		}
		return true;
	}
	
	/**
	* ���ڿ��� null�̰ų� ���ڿ������� �˻��Ͽ� , ���� ����ٸ� �⺻ ���ڿ��� ���� 
	* @param tobetested ���� ���ڿ�
	*/
	public final static String getString ( final Object tobetested , final String emptyString )	{
		if ( tobetested != null ) {
			return tobetested.toString().intern();
		}
		return emptyString;
	}
	
	
	/**
	* ���ڿ��� null�̰ų� ���ڿ������� �˻��Ͽ� , ���� ����ٸ� �⺻ ���ڿ��� ���� 
	* @param tobetested ���� ���ڿ�
	*/
	public final static String getString ( final String tobetested , final String emptyString )	{
		if ( ( tobetested != null )	&& ( !tobetested.trim().equals("") ) ) {
			return tobetested.intern();
		}
		return emptyString;
	}
	
	/**
	* ���ڿ��� null�̰ų� ���ڿ������� �˻��Ͽ� , ���� ����ٸ� �⺻ ���� ���� 
	* @param tobetested ���� ���ڿ�
	*/
	public final static int parseInt ( final String tobetested , final int defValue ) {
		if ( ( tobetested != null ) && ( !tobetested.trim().equals("") ) ) {
			try	{
				return Integer.parseInt (tobetested);
			} catch ( Exception e ) {
				// DO NOTHING return defValue
			}
		}
		return defValue;
	}
	
	/**
	* true True TRUE yes Yes YES ��� true return
	* ���ڿ��� null�̰ų� ���ڿ������� �˻��Ͽ� , ���� ����ٸ� �⺻ ���� ���� 
	* @param tobetested ���� ���ڿ�
	*/
	public final static boolean parseBoolean ( final String tobetested , final boolean defValue ) {
		if ( ( tobetested != null )	&& ( !tobetested.trim().equals("") ) ) {
			String str = tobetested.trim().toLowerCase();
			if ( str.equals ( "true" ) || str.equals ( "yes" ) ) {
				return true;
			} else {
				return false;
			}
		}
		
		return defValue;
	}
	
	/**
	* ���ڿ��� null�̰ų� ���ڿ������� �˻��Ͽ� , ���� ����ٸ� �⺻ ���� ���� 
	* @param tobetested ���� ���ڿ�
	*/
	public final static long parseLong ( final String tobetested , final long defValue ) {
		if ( ( tobetested != null ) && ( !tobetested.trim().equals("") ) ) {
			try	{
				return Long.parseLong (tobetested);
			} catch ( Exception e ) {
				// DO NOTHING return defValue
			}
		}
		return defValue;
	}
	
	/**
	* ���ڿ��� null�̰ų� ���ڿ������� �˻��Ͽ� , ���� ����ٸ� �⺻ ���� ���� 
	* @param tobetested ���� ���ڿ�
	*/
	public final static float parseFloat ( final String tobetested , final float defValue )	{
		if ( ( tobetested != null ) && ( !tobetested.trim().equals("") ) ) {
			try {
				return Float.parseFloat (tobetested);
			} catch ( Exception e ) {
				// DO NOTHING return defValue
			}
		}
		return defValue;
	}
	
    /**
    * ���ڿ��� null�̰ų� ���ڿ������� �˻��Ͽ� , ���� ����ٸ� �⺻ ���� ���� 
    * @param tobetested ���� ���ڿ�
    */
	public final static short parseShort ( final String tobetested , final short defValue )	{
		if ( ( tobetested != null ) && ( !tobetested.trim().equals("") ) ) {
			try	{
				return Short.parseShort (tobetested);
			} catch ( Exception e ) {
				// DO NOTHING return defValue
			}
		}
		return defValue;
	}
	
	/**
	* ��Ʈ�� �߶󳻱�(������ ����). StringTokenizer�̿� 
	* @param str �۾� ��Ʈ��
	* @param del ������
	* @return 
	*/
	public static StringTokenizer tokenizeString ( String str, String del )	{
		if ( isEmpty ( str ) ) return null;
		
		StringTokenizer tokenizer = new StringTokenizer ( str , del );
		
		return tokenizer;
	}
	
	/**
     * �ش繮�ڿ��� Ÿ�����ڵ����� ��ȯ
     * @param text
     * @param srcEnc
     * @param targetEnc
     * @return
     * @throws java.io.UnsupportedEncodingException
	 */
	public static final String encode ( String text , String srcEnc , String targetEnc ) throws java.io.UnsupportedEncodingException	{
		if ( text == null )	{
			return null;
		}
		
		return new String ( text.getBytes(srcEnc) , targetEnc );
	}
	
	/**
     * �� ���ڿ��� �ش� ���ڵ����� ��ȯ�Ͽ� ����
     * @param text
     * @param srcEnc
     * @return ���ڵ��� ���ڿ�
     * @throws java.io.UnsupportedEncodingException
	 */
	public static final String encodeFrom ( String text , String srcEnc )
									throws java.io.UnsupportedEncodingException	{
		if ( text == null )	{
			return null;
		}
		
		return new String ( text.getBytes(srcEnc) );
	}
	
	/**
	 *
	 */
	public static final String encodeFromISO8859 ( String text )
									throws java.io.UnsupportedEncodingException	{
		if ( text == null )	{
			return null;
		}
		
		return encodeFrom ( text ,  "ISO-8859-1" );
	}
	
	/**
	 *
	 */
	public static final String encodeTo ( String text , String targetEnc )
									throws java.io.UnsupportedEncodingException	{
		if ( text == null ) {
			return null;
		}
		
		return new String ( text.getBytes() , targetEnc );
	}
		
	/**
	* <Pre>
	* ��Ʈ�� �߶󳻱�(������ ����). �ظ��ϸ� tokenizeString�� ���� ���� ����. �ӵ� ���� 5��, 
	* ������, ���� String[]�� �ʿ��ϰų�, �� ���� token�� ���ܽ�Ű�� �ʹٸ� �� �޼ҵ带 ���ö�.
	* ����) ��ũ����¡ �� �� ���ڿ��� �����Ѵ�.
	* </Pre>
	* @param str �۾� ��Ʈ��
	* @param del ������
	* @param preserveDelimiter ������ ���� ���� 
	* @return �߶� ��Ʈ�� �������� ���ʷ� String[] �־� ��ȯ
	*/
	public static String[] tokenizeString2Array ( String str, String del ) {
		if ( isEmpty ( str ) ) return new String[0];
		
		if( str.lastIndexOf(del) != str.length() -1 ) str = str.concat(del);
		int lastIndex = 0;
		int index = str.indexOf ( del , lastIndex );
		
		int endIndex = str.length() -1;
		
		int size = 0;
		String[] tempArray = new String[10];
		
		while ( ( index >= 0 ) || ( lastIndex < endIndex ) ) {
			if ( tempArray.length < size + 1 ) {
				String [] newArray = new String[tempArray.length + 10];
				System.arraycopy ( tempArray , 0 , newArray , 0 , tempArray.length );
				tempArray = newArray;
			}
			
			String token = "";
			
			if ( index >= 0 ) {
				token = str.substring ( lastIndex , index );
				lastIndex = index + 1;
			} else if ( lastIndex < endIndex ) {
				token = str.substring ( lastIndex );
				lastIndex = endIndex;
			}
			
			if ( token.length() > 0 ) {
				tempArray[size] = token;
				size++;
			}
			
			index = str.indexOf ( del , lastIndex );
		}
		
		String [] strArray = new String[size];
		
		System.arraycopy ( tempArray , 0 , strArray , 0 , size );
		return strArray;
	}
	
	/**
	* <Pre>
	* ��Ʈ�� �߶󳻱�(������ ����). �ظ��ϸ� tokenizeString�� ���� ���� ����. �ӵ� ���� 5��, 
	* ������, ���� String[]�� �ʿ��ϰų�, �� ���� token�� ���ܽ�Ű�� �ʹٸ� �� �޼ҵ带 ���ö�.
	* ����) ��ũ����¡ �� �� ���ڿ��� �����Ѵ�.
	* </Pre>
	* @param str �۾� ��Ʈ��
	* @param del ������
	* @param preserveDelimiter ������ ���� ���� 
	* @return �߶� ��Ʈ�� �������� ���ʷ� String[] �־� ��ȯ
	*/
	public static String[] tokenizeString2Array (String str, char del )	{
		if ( isEmpty ( str ) ) return new String[0];
		
		String[] arrayToken = null;
		
		int l = str.length();
		StringBuffer sb = new StringBuffer(str.length());
		
		char[] charArr = str.toCharArray();
		
		char c;
		
		for(int i=0; i<l ; i++) {
			c=charArr[i];
			
			if(c==del) {
				if ( !sb.toString().trim().equals ("") ) {
					arrayToken = expandStringArray	( arrayToken , 1 );
					String part = sb.toString();
					arrayToken [ arrayToken.length - 1 ] = part;
					sb.delete ( 0, part.length()-1 );
				}				
			} else if(i==l-1) {
				sb.append(c);
				arrayToken = expandStringArray	( arrayToken , 1 );
				arrayToken [ arrayToken.length - 1 ] = sb.toString();
			} else {
				sb.append(c);
			}
		}//for END;
		
		return arrayToken;
	}
	
	/**
	* String Array ��� ���̱� 
	* @param sourceArray
	* @param expandLen ���̰����ϴ� ���� 
	*/
	public static String[] expandStringArray ( String[] sourceArray , int expandLen ) {
		String[] array = null;
		
		if ( sourceArray != null ) {
			int tokenLen = sourceArray.length;
			
			array = new String [ tokenLen + expandLen ];
			
			System.arraycopy ( sourceArray , 0 , array , 0 , sourceArray.length );
		} else {
			array = new String [expandLen];
		}
		
		return array;
	}
		
	/**
	* String Array ��� ���̱� 
	* @param sourceArray
	* @param string2Add �߰��� ���ڿ�
	*/
	public static String[] expandStringArray ( String[] sourceArray , String string2Add ) {
		String[] newArray = expandStringArray ( sourceArray , 1 );
		newArray [ newArray.length - 1 ] = string2Add;
		
		return newArray;
	}
		
	/**
	* Array ��ġ��
	* @param sourceArray
	* @param array2Add �߰��� ���ڿ� array
	*/
	public static String[] concatStringArray ( String[] sourceArray , String[] array2Add ) {
		if ( sourceArray == null ) {
			return array2Add;
		}
		
		if ( array2Add == null ) {
			return sourceArray;
		}
		
		String[] concatArray = new String [ sourceArray.length + array2Add.length ];
		
		System.arraycopy ( sourceArray , 0 , concatArray , 0 , sourceArray.length );
		
		System.arraycopy ( array2Add , 0 , concatArray , sourceArray.length , array2Add.length );
		
		return concatArray;
	}
	
	/**
	 * ���ڿ� �迭�� �����ڸ� �̿��Ͽ� �ϳ��� ��Ʈ������ �����.
	 * @param sourceArray
	 * @param delimiter
	 * @return
	 */
	public static String concatStringWithDelimiter ( String[] sourceArray , String delimiter ) {
		int i;
		StringBuffer concatArray = new StringBuffer();
		for( i=0 ; i<sourceArray.length ; i++ ){
			concatArray.append(sourceArray[i]);
			if(i<sourceArray.length-1)
				concatArray.append(delimiter);
		}
		return concatArray.toString();
	}
		
	/**
	* @param in_str ���� ���ڿ�
	* @param in_find �ٲ���� ���ڿ�
	* @param in_rep �ٲ�� �� ���ڿ�
	*/
	public static String replace( String in_str, String in_find, String in_rep ) {
        if ( in_str == null ) return null;
		StringBuffer sb = new StringBuffer( in_str.length( ) );

		int lenFind  = in_find.length( );

		int posFind;
		int pos = 0;

		while( true ) {
			posFind	= in_str.indexOf( in_find, pos );
			if( -1 == posFind ) {
				sb.append( in_str.substring( pos ) );
				break;
			}

			sb.append( in_str.substring( pos, posFind ) ).append( in_rep );
			pos = posFind + lenFind;
		}

		return	sb.toString( );
	}
	
    /**
     * �ش罺Ʈ���� ã�����ϴ� Character�� ��� �߰ߵǴ��� �Ǽ� üũ
     * @param source �����ڿ�
     * @param find ã�����ϴ� Char
     * @return int - ã���Ǽ� 
     */
	public static int count ( String source , char find ) {
		char[] cahracters = source.toCharArray();
		int count = 0;
		
		for ( int i = cahracters.length-1;i>=0;i--)	{
			if ( cahracters[i] == find ) {
				count++;
			}
		}//for END;
		
		return count;
	}
	
    /**
     * ������Ʈ�� ��(��Ű���� ����)
     * @param object �� ������Ʈ
     * @return ������Ʈ��
     */
	public static final String getClassShortName ( Object object ) {
		String clzName = object.getClass().getName();
		int lastIndex = clzName.lastIndexOf (".");
		
		if ( lastIndex > -1 && lastIndex < clzName.length() -1 ) {
			clzName = clzName.substring ( lastIndex + 1 );
		}
		
		return clzName;
	}
	
	public static final short ALIGN_LEFT = 1;
	public static final short ALIGN_RIGHT = -1;
	
	public static final String formatClassName ( Object object , int len ){
		String clzName = object.getClass().getName();
		
		if ( clzName.length() > len ) {
			return new String ( formatRightAlign ( clzName , len ) );
		} else {
			return new String ( format ( clzName , len ) );
		}
	}
	
	public static final String formatClassShortName ( Object object , int len ){
		String clzName = getClassShortName (object);
		
		if ( clzName.length() > len ) {
			return new String ( formatRightAlign ( clzName , len ) );
		} else {
			return new String ( format ( clzName , len ) );
		}
	}
	
	public static final String formatStr ( String value , int len , short align , char fill ){
		return new String ( format ( value , len , align , fill ) );
	}
	
	public static final String formatMessage ( Object[] values , int[] lens , String delimiter ){
		StringBuffer buffer = new StringBuffer(1024);
		
		int len = values.length;
		
		for ( int i = 0 ; i < len -1 ; i++) {
			buffer.append ( format ( values[i] , lens[i] ) )
				.append ( delimiter );
		}
		
		buffer.append ( format ( values[len -1] , lens[len -1] ) );
				
		return buffer.toString();
	}
	
	public static final char[] formatRightAlign ( Object value , int len ){
		return format ( ( ( value != null ) ? value.toString() :"" ) , len , ALIGN_RIGHT , ' ' );
	}
	
	public static final char[] format ( Object value , int len ){
		return format ( ( ( value != null ) ? value.toString() :"" ) , len , ALIGN_LEFT , ' ' );
	}
	
	public static final char[] format ( String value , int len ){
		return format ( value , len , ALIGN_LEFT , ' ' );
	}
	
	public static final char[] format ( String value , int len , short align , char fill ){
		char [] valueArray = new char[len];
		
		if ( value == null || value.length() < 1 ) {
			Arrays.fill ( valueArray , fill );
		} else {
			char[] strValue = value.toCharArray();
			int oldLen = strValue.length;
			int margin = len - oldLen;
			
			if ( margin == 0 ) {
				System.arraycopy ( strValue , 0, valueArray , 0 , len );
			} else if ( margin > 0 ) {
				if ( align > 0 ) {// left align
					System.arraycopy ( strValue , 0, valueArray , 0 , oldLen );
					Arrays.fill ( valueArray , len - margin  , len-1 , fill );
				} else {  // right align
					System.arraycopy ( strValue , 0, valueArray , margin, oldLen );
					Arrays.fill ( valueArray , 0  , margin, fill );
				}
			} else {
				if ( align > 0 ) {// left align
					System.arraycopy ( strValue , 0, valueArray , 0 , len );
				} else {  // right align
					System.arraycopy ( strValue , -margin, valueArray , 0 , len );
				}
			}
		}//if..else END;
		
		return valueArray;
	}
	
	/**
	 * ����ڿ�(strTarget)���� ���й��ڿ�(strDelim)�� �������� ���ڿ��� �и��Ͽ�
	 * �� �и��� ���ڿ��� �迭�� �Ҵ��Ͽ� ��ȯ�Ѵ�.
	 *
	 * @param strTarget �и� ��� ���ڿ�
	 * @param strDelim ���н�ų ���ڿ��μ� ��� ���ڿ����� ���Ե��� �ʴ´�.
	 * @param bContainNull ���еǾ��� ���ڿ��� ���鹮�ڿ��� ���Կ���.
	 *                     true : ����, false : �������� ����.
	 * @return �и��� ���ڿ��� ������� �迭�� �ݳ��Ͽ� ��ȯ�Ѵ�.
	 */
	public static String[] split(String strTarget, String strDelim){
		return split(strTarget, strDelim, true);
	}	

	public static String[] split(String strTarget, String strDelim, boolean bContainNull){
		// StringTokenizer�� �����ڰ� �������� ��ø�Ǿ� ���� ��� ���� ���ڿ��� ��ȯ���� ����.	
		// JDK 1.4���� Sting.split�� ������ ������ ������ Null�ϰ�� �������� �������� �ʽ��ϴ�.
		String[] result = null;
		if (strTarget != null) {
			int index = 0;
			Vector vc = new Vector();
			//String strCheck = new String(strTarget);
			String strCheck = strTarget;
			while(strCheck.length() != 0) {
				int begin = strCheck.indexOf(strDelim);
				if(begin == -1) {
					vc.add(index, strCheck);
					break;
				} else {
					int end = begin + strDelim.length();
					//System.out.println("strCheck.substring(0, " + begin + " ) : " + strCheck.substring(0, begin));
					if(begin != 0 || (begin == 0 && bContainNull))
						vc.add(index++, (begin == 0) ? null : strCheck.substring(0, begin));
					//System.out.println("strCheck.substring(" + end + " ) : " + strCheck.substring(end));
					strCheck = strCheck.substring(end);
					if(strCheck.length()==0 && bContainNull){
						vc.add(index, null);
						break;
					}
				}
			}
			if (vc.size() > 0) {
				result = new String[vc.size()];
				vc.copyInto(result);
			}
		}
		return result;
	}
	
	public static String[] toStrArray( Object obj ) {
	   if(obj instanceof String[]){
		   return (String[])obj;
	   }else{
		   String[] ret =  null;
		   if( ((String)obj) != null){
			   ret =  new String[1];
			   ret[0] = (String)obj;
		   }
           return ret;
	   }
    }

	public static String change2DigitString(int num) {
		String strNum = String.valueOf(num);
		if(strNum.length() == 1) {
			strNum = "0"+strNum;
		}

		return strNum;
	}
	
	/**
	 * NOTE : �ѱ��̳� �Ϻ����� ��� ���� ũ�Ⱑ ������ �޶� ���ڼ��� �׳� 10�ڷ� 
	 * ������ ��� ���ڼ��� �����ϴ� ������ �޶����� �ȴ�.
	 * ������ �ѱ��̳� �Ϻ���� ���� ascii ���� ����� ��� �� ���ڸ� 
	 * �� ���ڸ� �ν��Ͽ� ó���ϵ��� �Ѵ�.
	 */
	public static String getLimitString(String str, int limitSize) {
		limitSize = limitSize--;
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<str.length(); i++) {
			if ( i > limitSize ) {
				// 5���ڸ� ���͵� ������ 9�ڰ� display �Ǵ� �ͺ��� �ѱ���
				// ��ġ�ϴ� ������ �� �д�. ������ ���ڸ� �� ���δ�.
				sb.deleteCharAt(sb.length()-1);
				sb.append("...");
				break;
			}
			int value = (int)str.charAt(i);
			if (value > 127) {
				limitSize--;
			}
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	/**
     * �ش� ���ڿ��� ������ �����Ѹ�ŭ ���ʺ��� padder�� ä��������.
     * @param value �����ڿ�
     * @param length ����
     * @param padder ä������ ���ڿ�
     * @return
	 */
    public final static String lpad( String value, int length, String padder){
        StringBuffer temp = new StringBuffer();
        if (value.length() >= length) {
        	//return value.substring(0, length);
            return value;
        } 
        else {
            while (temp.length() + value.length() < length) {
                if (temp.length() + value.length() + padder.length() <= length) {
                    temp.append(padder);
                } else {
                    temp.append(padder.substring(0, length - (temp.length() + value.length())));
                }
            }
            temp.append(value);
            return temp.toString();
        }
    }
    
    /**
     * �ش� ���ڿ��� ������ �����Ѹ�ŭ ���ʺ��� padder�� ä��������.
     * @param value �����ڿ�
     * @param length ����
     * @param padder ä������ ���ڿ�
     * @return
     */
    public final static String lpad( int value, int length, String padder){
        return lpad(String.valueOf(value), length, padder);
    }
    
    /**
     * �ش� ���ڿ��� ������ �����Ѹ�ŭ ���ʺ��� padder�� ä��������.
     * @param value �����ڿ�
     * @param length ����
     * @param padder ä������ ���ڿ�
     * @return
     */
    public final static String lpad( long value, int length, String padder){
        return lpad(String.valueOf(value), length, padder);
    }
    
    /**
     * Text���ڸ� HTML���ڷ� ��ȯ
     * @param  Text String
     * @return The new String
     */
    public static String toHtml(String args) {
        return toHtml(args,"");
    }
    
    public static String toHtml(String args,String filterChar) {
        String str="";
        try {   
            StringBuffer strTxt = new StringBuffer("");
            char charBuff;
            int len=0;
            int i=0;
            
            len = args.length();
            
            for (i=0;i<len;i++) {
                charBuff = (char)args.charAt(i);
                if(filterChar.indexOf(charBuff) >= 0) {
                    strTxt.append(charBuff);    
                    continue;
                }
                switch (charBuff) {
                    case '<' :
                        strTxt.append("&lt");
                        break;
                    case '>' :
                        strTxt.append("&gt");
                        break;
                    case 13 :
                        strTxt.append("<br>");
                        break;
                    case 10 :
                        strTxt.append("");
                        break;
                    case ' ' :
                        strTxt.append("&nbsp;");
                        break;
                    case '&' :
                        strTxt.append("&amp;");
                        break;
                    default :                       
                        strTxt.append(charBuff);
                }//switch
            }   //for
            str = strTxt.toString();
        }catch (Exception ex) {     
        }
        return str;
    } //end toHtml()

    public static String toText(String args) {
        return toText(args,"");
    }
    
    /**
     * HTML���ڸ� Text�� ��ȯ
     * @param args
     * @param filterStr �ش� Str�� ��ȯ���� �ʴ´�.(�ɼ�ó��)
     * @return
     */
    public static String toText(String args,String filterStr) {
        String strHtml = args;
        try {   
            if( !filterStr.equalsIgnoreCase("&amp;")) {
                strHtml = replace(strHtml, "&amp;", "!*!");
                strHtml = replace(strHtml, "!*!", "&");
            }
            if( !filterStr.equalsIgnoreCase("&quot;")) {
                strHtml = replace(strHtml, "&quot;", "\"");
            }
            if( !filterStr.equalsIgnoreCase("&#39;")) {
                strHtml = replace(strHtml, "&#39;", "\'");
            }
            if( !filterStr.equalsIgnoreCase("&lt;")) {
                strHtml = replace(strHtml, "&lt;", "<");
            }
            if( !filterStr.equalsIgnoreCase("&gt;")) {
                strHtml = replace(strHtml, "&gt;", ">");
            }
            if( !filterStr.equalsIgnoreCase("&nbsp;")) {
                strHtml = replace(strHtml, "&nbsp;", " ");
            }
            if( !filterStr.equalsIgnoreCase("<br>")) {
                strHtml = replace(strHtml, "<br>", "\n");
            }
        }catch (Exception ex) {     
        }
        return strHtml;
    } //end toText()

    /**
     * ������ HTML���ÿ� ���� HTML��ȯ.
     * @param str
     * @return
     */
    public static String forEditorContent(String str) {
        String strDetail = str;
        String strC = "";
        strC = replace(strDetail, "&#183;", "��");
        strC = replace(strC, "&#126;", "~");
        strC = replace(strC, "!*!", "&amp;");
        
        strC = replace(strC, "\"", "&quot;");
        strC = replace(strC, "\'", "&#39;");
        strC = replace(strC, "<", "&lt;");
        strC = replace(strC, ">", "&gt;");
        strC = replace(strC, "&nbsp;", "&amp;nbsp;");                
        //strC = replace(strC, " ", "&nbsp;");                
        //strC = replace(strC, "\n", "<br>");    
        strC = replace(strC, "\r", "");   
        
        return strC;
    }
    
    public static void main(String[] args) throws Exception {
    	String str = "a"+"\07"+"b"+"\07"+"c"+"\07";
    	String[] arr = tokenizeString2Array(str, "\07");
    	
    	System.err.println("arr:"+arr.length);
    	for (int i = 0; i < arr.length; i++) {
    		System.err.println("arr["+i+"]:"+arr[i]);
		}
    }

}
