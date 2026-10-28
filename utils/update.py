import os

def rename_recipes_folders(data_directory):
    # Kiểm tra xem đường dẫn có tồn tại không
    if not os.path.exists(data_directory):
        print(f"Không tìm thấy đường dẫn thư mục: {data_directory}")
        return

    renamed_count = 0

    # os.walk với topdown=False để duyệt từ các thư mục con sâu nhất lên trên, 
    # tránh lỗi thay đổi cấu trúc cây thư mục khi đang duyệt
    for root, dirs, files in os.walk(data_directory, topdown=False):
        for dirname in dirs:
            # Kiểm tra nếu tên thư mục là 'recipes'
            if dirname == "recipes":
                old_path = os.path.join(root, dirname)
                new_path = os.path.join(root, "recipe") # Đổi thành 'recipe'
                
                try:
                    os.rename(old_path, new_path)
                    print(f"Đã đổi tên: {old_path} -> {new_path}")
                    renamed_count += 1
                except Exception as e:
                    print(f"Lỗi khi đổi tên thư mục {old_path}: {e}")

    print(f"\nHoàn tất! Đã đổi tên thành công {renamed_count} thư mục.")

if __name__ == "__main__":
    # Điền đường dẫn tới thư mục data của bạn vào đây
    # Ví dụ: r"D:\Project\thirst-was-taken-reload\src\main\resources\data"
    data_dir = input("Nhập đường dẫn đến thư mục data của mod: ").strip()
    
    # Xóa dấu nháy kép nếu người dùng lỡ copy dạng path trong Windows
    data_dir = data_dir.strip('"').strip("'")
    
    rename_recipes_folders(data_dir)