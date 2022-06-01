package pe.com.bank.wallet.bootcoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.bank.wallet.bootcoin.document.WalletBootcoinDocument;

@Repository
public interface WalletBootcoinRepository  extends ReactiveMongoRepository<WalletBootcoinDocument, String>{

}
