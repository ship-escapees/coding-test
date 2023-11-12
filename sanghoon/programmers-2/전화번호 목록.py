def solution(phone_book):
    phone_book.sort()

    for i in range(len(phone_book) - 1):
        if phone_book[i + 1].startswith(phone_book[i]):
            return False

    return True

phone_book = ["12", "123", "1235", "567", "88"]
solution(phone_book)