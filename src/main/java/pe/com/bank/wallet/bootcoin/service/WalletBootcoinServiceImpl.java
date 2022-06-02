package pe.com.bank.wallet.bootcoin.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.bank.wallet.bootcoin.document.WalletBootcoinDocument;
import pe.com.bank.wallet.bootcoin.dto.WalletBootcoinDTO;
import pe.com.bank.wallet.bootcoin.repository.WalletBootcoinRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@Service
public class WalletBootcoinServiceImpl implements WalletBootcoinService{
	
	
	WalletBootcoinRepository walletBootCoinRepository;
	
	public Flux<WalletBootcoinDocument> getAllWalletBootcoin(){
		return walletBootCoinRepository.findAll();
	}
	
	public Mono<WalletBootcoinDocument> getWalletBootcoinById(String walletBootcoinId){
		return walletBootCoinRepository.findById(walletBootcoinId);
	}
	
	public Mono<WalletBootcoinDocument> saveWalletBootcoin(WalletBootcoinDocument walletBootcoinDocument){
		return walletBootCoinRepository.save(walletBootcoinDocument);
	}
	
	public Mono<WalletBootcoinDocument> updateWalletBootcoinById(WalletBootcoinDocument updateWalletBootcoin,String walletBootcoinId){
		return walletBootCoinRepository.findById(walletBootcoinId).flatMap( walletBootcoin -> {
			walletBootcoin.setDocumentType(updateWalletBootcoin.getDocumentType() != null ?updateWalletBootcoin.getDocumentType():walletBootcoin.getDocumentType());
			walletBootcoin.setDocumentNumber(updateWalletBootcoin.getDocumentNumber() != null ?updateWalletBootcoin.getDocumentNumber():walletBootcoin.getDocumentNumber());
			walletBootcoin.setBalance(updateWalletBootcoin.getBalance() != null ?updateWalletBootcoin.getBalance():walletBootcoin.getBalance());
			walletBootcoin.setPhoneNumber(updateWalletBootcoin.getPhoneNumber() != null ?updateWalletBootcoin.getPhoneNumber():walletBootcoin.getPhoneNumber());
			walletBootcoin.setEmail(updateWalletBootcoin.getEmail() != null ?updateWalletBootcoin.getEmail():walletBootcoin.getEmail());
			walletBootcoin.setYankiPhoneNumber(updateWalletBootcoin.getYankiPhoneNumber() != null ?updateWalletBootcoin.getYankiPhoneNumber():walletBootcoin.getYankiPhoneNumber());
			walletBootcoin.setNumberAccount(updateWalletBootcoin.getNumberAccount() != null ?updateWalletBootcoin.getNumberAccount():walletBootcoin.getNumberAccount());
			return walletBootCoinRepository.save(walletBootcoin);
		});
	}
	
	public Mono<Void> deleteWalletBootcoinById(String walletBootcoinId){
		return walletBootCoinRepository.deleteById(walletBootcoinId);
	}
	
	@Bean
	 Consumer<WalletBootcoinDTO> updateAmountWalletBootcoin() {
	    return updateAmountWalletBootcoin -> {	    
	    	
	    	getWalletBootcoinById(updateAmountWalletBootcoin.getSourceWalletBootcoinId()).flatMap( walletSource -> {

	    		return updateWalletBootcoinById(new WalletBootcoinDocument(null,null,null,walletSource.getBalance()-updateAmountWalletBootcoin.getAmount(),null,null,null,null),
		    			updateAmountWalletBootcoin.getSourceWalletBootcoinId()).flatMap( updateSource -> {
		    				return walletBootCoinRepository.findById(updateAmountWalletBootcoin.getDestinatonWalletBootcoinId()).flatMap( walletDestination -> {
		    					return updateWalletBootcoinById(new WalletBootcoinDocument(null,null,null,walletDestination.getBalance()+updateAmountWalletBootcoin.getAmount(),null,null,null,null),
		    			    			updateAmountWalletBootcoin.getDestinatonWalletBootcoinId());
		    				});
		    			});
	    	}).subscribe();
	    	
	    	
	    		           
	    };	
	 }	
	

}
