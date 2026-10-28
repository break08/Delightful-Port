import json
import os


def update_json_data(data):
    """Hàm đệ quy quét qua mọi dict/list trong JSON để cập nhật giá trị"""
    if isinstance(data, dict):
        new_dict = {}
        for key, value in data.items():
            # 1. Đổi "type": "forge:..." -> "neoforge:..."
            if key == "type" and isinstance(value, str):
                if value.startswith("forge:"):
                    value = value.replace("forge:", "neoforge:", 1)

            # 2. Đổi "tag": "forge:..." -> "c:..."
            elif key == "tag" and isinstance(value, str):
                if value.startswith("forge:"):
                    value = value.replace("forge:", "c:", 1)

            # Đệ quy vào các value bên trong
            new_dict[key] = update_json_data(value)

        # 3. Chuẩn hóa kết quả "result" cho 1.21.1: đổi "item" -> "id"
        if "result" in new_dict and isinstance(new_dict["result"], dict):
            res = new_dict["result"]
            if "item" in res and "id" not in res:
                res["id"] = res.pop("item")

        return new_dict

    elif isinstance(data, list):
        return [update_json_data(item) for item in data]

    return data


def process_recipe_files(directory):
    if not os.path.exists(directory):
        print(f"❌ Đường dẫn không tồn tại: {directory}")
        return

    updated_files = 0

    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith(".json"):
                file_path = os.path.join(root, file)

                try:
                    with open(file_path, "r", encoding="utf-8") as f:
                        data = json.load(f)

                    # Tiến hành biến đổi dữ liệu
                    updated_data = update_json_data(data)

                    # Ghi đè lại file JSON với định dạng chuẩn
                    with open(file_path, "w", encoding="utf-8") as f:
                        json.dump(updated_data, f, indent=2, ensure_ascii=False)

                    print(f"✅ Đã cập nhật: {file_path}")
                    updated_files += 1

                except Exception as e:
                    print(f"⚠️ Không thể đọc/sửa file {file_path}: {e}")

    print(f"\n🎉 Hoàn tất! Đã cập nhật thành công {updated_files} file JSON.")


if __name__ == "__main__":
    target_dir = input(
        "Nhập đường dẫn thư mục data của mod (ví dụ src/main/resources/data): "
    ).strip()
    target_dir = target_dir.strip('"').strip("'")

    process_recipe_files(target_dir)