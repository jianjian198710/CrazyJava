package codes10_4;

public class AuctionTest {

	/**
	 * ͨ�^���������f��̎��һ������,��catch�K�нY��throw�Z��
	 */
	private double initPrice = 30.0;
	
	public void bid(String bidPrice) throws Exception{
		double d =0.0;
		try{
			d = Double.parseDouble(bidPrice);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("�����ǔ�ֵ!");
		}
		if(initPrice>d){
			throw new Exception("���ăr��ԭʼ�r��!");
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
