/*  -> Designed for testing and development purposes.
 *  -> Project to design a small places prototype app.
 *  -> Development Phase -- Premature.
 *  -> Project Type -- Educational.
 *  -> Institute -- University Institute Of Technology, Burdwan University.
 *  -> Owner/Code file Designer :
 *             @ Name - Palash Sarkar.
 *             @ Department - Computer Science And Engineering.
 *             @ Roll.Number - 2014_1038.
 *             @ Email - palashsarkar0007@gmail.com.
 *  -> Copyright Norms - Every piece of code given below 
 *                       has been written by 'Palash Sarkar (Tj07)'©,
 *                       and he holds the rights to the file. Not meant to be
 *                       copied or tampered without prior permission
 *                       from the author. 
 *  -> Guide - Asst.Proff. Dr. S.K. Gupta.            
 */

package com.aps.datahandling;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class AES 
{
      
       private Cipher cpr = null;
       private KeyGenerator kg = null;
       private SecretKey sk = null;

      public AES()
      {
            try 
              {
                    kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    cpr = Cipher.getInstance("AES");
              } catch (NoSuchAlgorithmException ex) 
                    {
                           Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                catch (NoSuchPaddingException ex) 
                   {
                           Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
                   }
                finally
                     {
                          setSecretKey(kg.generateKey());
                     }
                 
      }
      
      private void setSecretKey(SecretKey sk)
      {
              this.sk = sk;
      }
      
      public String encrypt(String plainText)throws Exception 
      {
	     byte [] plainTextByte = plainText.getBytes();
             cpr.init(Cipher.ENCRYPT_MODE, sk);
             byte [] encryptedByte = cpr.doFinal(plainTextByte);
             Base64.Encoder encoder = Base64.getEncoder();
             String encryptedText = encoder.encodeToString(encryptedByte);
             String encryptedKey = encoder.encodeToString(sk.getEncoded());
             return (encryptedText+"\n"+encryptedKey+"\n");
      }
      
      public String decrypt(String encryptedText, String encryptedKey)throws Exception 
      {
             Base64.Decoder decoder = Base64.getDecoder();
             setSecretKey(new SecretKeySpec(decoder.decode(encryptedKey),0,decoder.decode(encryptedKey).length,"AES"));
             byte [] encryptedTextByte = decoder.decode(encryptedText);
             cpr.init(Cipher.DECRYPT_MODE, sk);
             byte [] decryptedByte = cpr.doFinal(encryptedTextByte);
             String decryptedText = new String(decryptedByte);
             return (decryptedText);
      }
      
}
