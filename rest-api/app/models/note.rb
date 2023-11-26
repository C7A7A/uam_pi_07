class Note < ApplicationRecord
  belongs_to :company
  validates :content, presence: true, uniqueness: true
end
