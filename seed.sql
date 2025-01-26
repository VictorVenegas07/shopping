INSERT INTO 
  category (
    id, 
    created_at, 
    updated_at, 
    name
  )
VALUES
  (1, '2025-01-26 10:00:00', '2025-01-26 10:00:00', 'Electronics'),
  (2, '2025-01-26 10:10:00', '2025-01-26 10:10:00', 'Fashion'),
  (3, '2025-01-26 10:20:00', '2025-01-26 10:20:00', 'Home Appliances');

INSERT INTO 
  product_detail (
    id, 
    created_at, 
    updated_at, 
    description, 
    manufacturer
  )
VALUES
  (
    1, 
    '2025-01-26 13:45:00', 
    '2025-01-26 13:45:00', 
    'High-quality wireless headphones with noise cancellation.', 
    'Sony'
  ),
  (
    2, 
    '2025-01-26 13:46:00', 
    '2025-01-26 13:46:00', 
    'Ergonomic mechanical keyboard with RGB lighting.', 
    'Logitech'
  ),
  (
    3, 
    '2025-01-26 13:47:00', 
    '2025-01-26 13:47:00', 
    'Advanced smartphone with 128GB storage and AMOLED display.', 
    'Samsung'
  ),
  (
    4, 
    '2025-01-26 13:48:00', 
    '2025-01-26 13:48:00', 
    'Gaming laptop with RTX 4060 GPU and 16GB RAM.', 
    'Asus'
  );
  
  insert into 
    product (
      id, 
      created_at, 
      updated_at, 
      name, 
      price, 
      category_id, 
      detail_id
    )
  values
    (
      $id, 
      $created_at, 
      $updated_at, 
      $name, 
      $price, 
      $category_id, 
      $detail_id
    );
    INSERT INTO 
      product (
        id, 
        created_at, 
        updated_at, 
        name, 
        price, 
        category_id, 
        detail_id
      )
    VALUES
      (
        1, 
        '2025-01-26 14:00:00', 
        '2025-01-26 14:00:00', 
        'Wireless Headphones', 
        199.99, 
        1, 
        1
      ),
      (
        2, 
        '2025-01-26 14:10:00', 
        '2025-01-26 14:10:00', 
        'Mechanical Keyboard', 
        89.99, 
        1, 
        2
      ),
      (
        3, 
        '2025-01-26 14:20:00', 
        '2025-01-26 14:20:00', 
        'Smartphone', 
        699.99, 
        1, 
        3
      ),
      (
        4, 
        '2025-01-26 14:30:00', 
        '2025-01-26 14:30:00', 
        'Gaming Laptop', 
        1299.99, 
        1, 
        4
      );