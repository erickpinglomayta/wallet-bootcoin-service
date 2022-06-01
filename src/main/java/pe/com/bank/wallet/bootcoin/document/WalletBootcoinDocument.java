package pe.com.bank.wallet.bootcoin.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "wallet_bootcoin")
public class WalletBootcoinDocument {
	
	@Id
	private String walletBootcoinId;
	private String documentType;
	private Long documentNumber;
	private Double balance;
	private Long phoneNumber;
	private String email;

}
