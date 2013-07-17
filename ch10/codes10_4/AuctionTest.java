package codes10_4;

public class AuctionTest {

	/**
	 * 通過多個方法協作處理一個異常,在catch塊中結合throw語句
	 */
	private double initPrice = 30.0;
	
	public void bid(String bidPrice) throws Exception{
		double d =0.0;
		try{
			d = Double.parseDouble(bidPrice);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("包含非數值!");
		}
		if(initPrice>d){
			throw new Exception("起拍價比原始價低!");
		}
		initPrice = d;
	}
	
	public static void main(String[] args) {
		AuctionTest at = new AuctionTest();
		try{
			at.bid("df");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
