package com.seismaismais.praiser.service;

import java.io.IOException;
import java.util.List;

import com.seismaismais.praiser.model.Slide;

public interface DownloadService {
	public String generatePptx(Slide slide) throws IOException;
	public List<byte[]> generateImage(String[] slidesBase64);
}
