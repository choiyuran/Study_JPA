package jpabook.jpashop.service;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuntity) {
        Item findItem = itemRepository.findOne(itemId);
//        findItem.change(price, name, stockQuantity);      의미 있는 메서드를 넣어서 만들어 준다(setter말고)
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuntity);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(long itemId) {
        return itemRepository.findOne(itemId);
    }
}
