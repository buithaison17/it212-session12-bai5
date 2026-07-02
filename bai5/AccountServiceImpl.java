@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public AccountResponse register(AccountRequest request) {

        if (request.getFullName() == null) {
            throw new RuntimeException("Name null");
        }

        if (repository.existsByCitizenId(request.getCitizenId())) {
            throw new RuntimeException("Citizen exists");
        }

        if (repository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone exists");
        }

        Account account = new Account();

        account.setFullName(request.getFullName());
        account.setPhone(request.getPhone());
        account.setEmail(request.getEmail());
        account.setCitizenId(request.getCitizenId());

        account.setAccountNumber(UUID.randomUUID().toString());

        repository.save(account);

        AccountResponse response = new AccountResponse();

        response.setAccountId(account.getId());
        response.setStatus("PENDING");

        return response;
    }

}