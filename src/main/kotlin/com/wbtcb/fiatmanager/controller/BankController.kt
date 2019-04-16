package com.wbtcb.fiatmanager.controller
import com.wbtcb.fiatmanager.model.entity.repository.BankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@RestController
@RequestMapping("/bank")
class BankController @Autowired constructor(
    private val bankRepository: BankRepository
) {

    @GetMapping
    @ResponseBody
    fun all(): ResponseEntity<*>
    {
        return ResponseEntity(bankRepository.findAllAsDto(), HttpStatus.OK)
    }
}
