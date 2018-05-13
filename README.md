# correcao


	@Override
	public AnexoDTO storeAdvanced(MultipartFile file) {

		AnexoDTO anexo = new AnexoDTO();
		
		HttpHeaders headers = criaHeaders();
		
		ResponseEntity<AnexoDTO> resposta = null;
		
		// processa arquivo
		InputStream is;
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");

			is = file.getInputStream();
			byte[] bytes = IOUtils.toByteArray(is);
	        
			md.update(bytes);
						
			byte[] mdbytes = md.digest();
			// convert the byte to hex format method 1
	        StringBuilder sb2 = new StringBuilder();
	        for (int i = 0; i < mdbytes.length; i++) {
	          sb2.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
			
			anexo.setNomeAnexo(file.getOriginalFilename());
			anexo.setAnexo(Base64.getEncoder().encodeToString(bytes));
			anexo.setTipoAnexo(sb2.toString());

			HttpEntity<AnexoDTO> request = new HttpEntity<>(anexo, headers);

			resposta = restTemplate.postForEntity(config.getendPointAnexo(),
					request, AnexoDTO.class);

			anexo = resposta.getBody();

		} catch (Exception e) {
			this.buildError(ERRO_ANEXO, HttpStatus.INTERNAL_SERVER_ERROR, e, logger);
		}
		
		return anexo;		
		
	}
