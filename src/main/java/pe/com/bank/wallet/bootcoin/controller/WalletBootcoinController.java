package pe.com.bank.wallet.bootcoin.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.com.bank.wallet.bootcoin.service.WalletBootcoinService;
import pe.com.bank.wallet.bootcoin.document.WalletBootcoinDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RequestMapping("/v1")
@RestController
public class WalletBootcoinController {
	
	WalletBootcoinService walletBootcoinService;
	
	@GetMapping("/getAllWalletBootcoin")
	public Flux<WalletBootcoinDocument> getAllWalletBootcoin(){
		return walletBootcoinService.getAllWalletBootcoin();
	}
	
	@GetMapping("/getWalletBootcoinById/{walletBootcoinId}")
	public Mono<WalletBootcoinDocument> getWalletBootcoinById(@PathVariable String walletBootcoinId){
		return walletBootcoinService.getWalletBootcoinById(walletBootcoinId);
	}
	
	@PostMapping("/saveWalletBootcoin")
	public Mono<WalletBootcoinDocument> saveWalletBootcoin(@RequestBody WalletBootcoinDocument walletBootCoinDocument){
		return walletBootcoinService.saveWalletBootcoin(walletBootCoinDocument);
	}
	
	@PutMapping("/updateWalletBootcoinById/{walletBootcoinId}")
	public Mono<WalletBootcoinDocument> updateWalletBootcoinById(@RequestBody WalletBootcoinDocument walletBootcoinDocument,@PathVariable String walletBootcoinId){
		return walletBootcoinService.updateWalletBootcoinById(walletBootcoinDocument, walletBootcoinId);
	}
	
	@DeleteMapping("/deleteWalletBootcoinById/{walletBootcoinId}")
	public Mono<Void> deleteWalletBootcoinById(String walletBootcoinId){
		return walletBootcoinService.deleteWalletBootcoinById(walletBootcoinId);
	}
	
}
