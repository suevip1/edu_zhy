import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Admin.
 * Time 2024/4/2 10:39
 * Desc 文件描述
 */
public class TextVideoWatermarkTest {


	@Test
	public void TextWatermark(){
		//		String ffmpegCommand = "ffmpeg -i " + videoInputPath +
//				" -vf drawtext=text='" + textWatermark + "':fontcolor=white:fontsize=24:x=10:y=10" +
//				" -codec:a copy " + videoOutputPath;

		String videoInputPath = "C:\\Users\\Admin\\Desktop\\zhy加水印\\原视频\\0.mp4"; // 视频输入路径
		String textWatermark = "HELLO"; // 文本水印内容
		String videoOutputPath = "C:\\Users\\Admin\\Desktop\\zhy加水印\\文字水印视频\\01.mp4"; // 输出视频路径
		// 替换为实际的 FFmpeg 可执行文件路径
		String ffmpegPath = "C:\\Users\\Admin\\Downloads\\ffmpeg-6.1.1-full_build\\bin\\ffmpeg.exe";
		String ffmpegCommand = ffmpegPath + " -i " + videoInputPath +
				" -vf drawtext=text='" + textWatermark + "':fontcolor=white:fontsize=24:x=10:y=10" +
				" -codec:a copy " + videoOutputPath;

		try {
			Process process = Runtime.getRuntime().exec(ffmpegCommand);
			InputStream inputStream = process.getErrorStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();

			System.out.println("文本水印添加完成！");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@Test
	public void TextWatermarkV2(){
		String videoInputPath = "C:\\Users\\Admin\\Desktop\\zhy加水印\\原视频\\0.mp4"; // 视频输入路径
		String textWatermark = "HELLO"; // 文本水印内容
		String videoOutputPath = "C:\\Users\\Admin\\Desktop\\zhy加水印\\文字水印视频"; // 输出视频路径
		// 替换为实际的 FFmpeg 可执行文件路径
		String ffmpegPath = "C:\\Users\\Admin\\Downloads\\ffmpeg-6.1.1-full_build\\bin\\ffmpeg.exe";

		try {
			String command = ffmpegPath + " -i " + videoInputPath +
					" -vf drawtext=text='" + textWatermark + "':fontcolor=white:fontsize=24:x=10:y=10" +
					" -codec:a copy " + videoOutputPath;
			Process process = Runtime.getRuntime().exec(command);

			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("水印添加成功，输出文件保存在：" + videoOutputPath);
			} else {
				System.out.println("水印添加失败");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
