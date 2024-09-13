import org.junit.Test;

/**
 * Created by w_zhanghongyi
 * Time 2024/8/20 9:59
 * Desc 文件描述
 */
public class SalesmanTest {



	@Test
	public void test1() {
		int shardingId = getShardingId(497230021L);

		System.out.println(shardingId);


	}

	@Test
	public void test2() {


	}





	/**
	 * 获取分片键id
	 *
	 * @param businessId 业务id
	 * @return
	 */
	public static int getShardingId(Long businessId) {
//		if (Env.isQa() || Env.isDaily() ||Env.isDev()) {
			//如果是预发或线上环境，则分1024个表，否则分512个表
//			long sharding = businessId % 512;
//			return (int)sharding;
//		}
		long sharding = businessId % 1024;
		return (int)sharding;
	}

}
