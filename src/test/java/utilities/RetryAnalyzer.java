package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer{
	public int retryCount=0;
	public static final int maxRetryCount=1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount<maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
