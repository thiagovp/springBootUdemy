/**
 * 
 */
package com.veloso.api;

import static org.junit.Assert.*;

import org.junit.Test;

import com.veloso.api.utils.SenhaUtils;

/**
 * @author thiag
 *
 */
public class TesteSenha {

	@Test
	public void test() {
		String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
		System.out.println("Senha encoded = "+senhaEncoded);
		
		senhaEncoded = SenhaUtils.gerarBCrypt("123456");
		System.out.println("Senha encoded novamente = "+senhaEncoded);
		
		System.out.println("Senha válida:"+SenhaUtils.senhaValida("123456", senhaEncoded));
		
		assertTrue(SenhaUtils.senhaValida("123456", senhaEncoded));
	}

}
