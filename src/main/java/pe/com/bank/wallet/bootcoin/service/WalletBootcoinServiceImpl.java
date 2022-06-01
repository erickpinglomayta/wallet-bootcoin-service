package pe.com.bank.wallet.bootcoin.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.bank.wallet.bootcoin.document.WalletBootcoinDocument;
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
			return walletBootCoinRepository.save(walletBootcoin);
		});
	}
	
	public Mono<Void> deleteWalletBootcoinById(String walletBootcoinId){
		return walletBootCoinRepository.deleteById(walletBootcoinId);
	}

}
