package pe.com.bank.wallet.bootcoin.service;

import pe.com.bank.wallet.bootcoin.document.WalletBootcoinDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletBootcoinService {
	
	
	public Flux<WalletBootcoinDocument> getAllWalletBootcoin();
	public Mono<WalletBootcoinDocument> getWalletBootcoinById(String walletBootcoinId);
	public Mono<WalletBootcoinDocument> saveWalletBootcoin(WalletBootcoinDocument walletBootCoinDocument);
	public Mono<WalletBootcoinDocument> updateWalletBootcoinById(WalletBootcoinDocument walletBootcoinDocument,String walletBootcoinId);
	public Mono<Void> deleteWalletBootcoinById(String walletBootcoinId);

}
