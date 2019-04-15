package com.wbtcb.fiatmanager.controller
import com.wbtcb.fiatmanager.model.entity.Bank
import com.wbtcb.fiatmanager.model.entity.repository.BankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BankController @Autowired constructor(
    private val bankRepository: BankRepository
) {

    @GetMapping("/banks")
    fun all(): List<Bank>
    {
        return bankRepository.findAll()
    }
    /*   @PostMapping("/banks")
    Bank newBank(@RequestBody Bank  )
}
*/
}
